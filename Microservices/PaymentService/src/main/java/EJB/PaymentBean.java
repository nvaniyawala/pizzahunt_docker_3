/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package EJB;

import client.IClientCustomer;
import client.IClientOrder;
import entities.OrderMaster;
import javax.ejb.Lock;
import javax.ejb.LockType;
//import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.eclipse.microprofile.faulttolerance.Asynchronous;
import org.eclipse.microprofile.faulttolerance.Bulkhead;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import utilities.PHResponseType;

/**
 *
 */
@Stateless
public class PaymentBean implements PaymentBeanLocal {

   // @PersistenceContext(unitName = "orderpu")
        @PersistenceContext(unitName = "ordersyspu")

    EntityManager em;

    @Inject
    @RestClient
    IClientOrder cli;

    @Inject
    @RestClient
    IClientCustomer custCli;

    @Lock(LockType.READ)
    //@Asynchronous
    //@Bulkhead(1)
    @Override
    public PHResponseType doPaymentAndPlaceOrder(OrderMaster order) {
        PHResponseType phr = new PHResponseType();
        synchronized(this)
        {
        try {
            if (order.getPaymentMethod().equals("CREDIT")) {

                Double userCredits = custCli.getUserCredits(order.getUserId().getId());
                System.out.println("credit "+userCredits);
                if (userCredits < order.getPayableAmount()) {
                    phr.setStatus(405);
                    phr.setMessage("Payment Failed !! You don't have enough credits to Pay.");
                    return phr;
                } else {
                    phr.setStatus(200);
                    phr.setMessage("Payment Successfull");
                }
                return phr;
            } else {
                phr.setStatus(200);
                phr.setMessage("Payment Successfull");
                return phr;
            }
        } catch (Exception ex) {
           // phr.setMessage("Payment Failed due to some Exception.");
            phr.setMessage("request to customer service failed "+ ex.getMessage().toString());
            phr.setStatus(404);
            return phr;
        }
        }
    }

    @Override
    public OrderMaster getOrderById(String id) {
        OrderMaster order = (OrderMaster) em.createNamedQuery("OrderMaster.findById").setParameter("id", id).getSingleResult();
        return order;

    }

    @Override
    public Boolean updateOrderStatus(OrderMaster order, String status) {
        if (em.contains(order)) {
            order.setOrderStatus(status);
            em.merge(order);
            return true;
        }
        return false;
    }
}
