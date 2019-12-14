package com.person.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.person.entity.PersonsEntity;
import com.person.vo.PersonVO;

//I want this class should work as a listener for JMS Server for queue
//which JNDI Name = "/queue/orderMessage"
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "/queue/personProcessing"),
		@ActivationConfigProperty(propertyName = "reconnectAttempts", propertyValue = "-1"),
		@ActivationConfigProperty(propertyName = "setupAttempts", propertyValue = "-1") })
/* This need to implement the MessageListener */
public class PersonDataProcessingMDB implements MessageListener {

	@PersistenceContext(unitName = "personMessagePersistence")
	private EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void onMessage(Message arg0) {
		System.out.println(arg0.toString());
		ObjectMessage objectMessage = (ObjectMessage) arg0;
		System.out.println(objectMessage.toString());
		System.out.println("&&&&&&&&&& HI(BEFORE TRY) &&&&&&&&&&");

		try {
			if (objectMessage.getObject() instanceof PersonVO) {
				System.out
						.println("&&&&&&&&&& INSIDE IF ABOVE TYPE CASTING&&&&&&&&&&");

				PersonVO personsVO = null;
				try {
					System.out.println("&&&&&&&&&& INSIDE TRY&&&&&&&&&&");

					personsVO = (PersonVO) objectMessage.getObject();
				} catch (JMSException e) {
					System.out.println("Exception in Type Casting");
					e.printStackTrace();
				}
				System.out
						.println("&&&&&&&&&& INSIDE IF ABOVE BELOW CASTING&&&&&&&&&&");

				System.out
						.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println(personsVO);

				PersonsEntity entity = new PersonsEntity();

				entity.setEmail(personsVO.getEmail());
				entity.setPassword(personsVO.getPassword());
				entity.setCountry(personsVO.getCountry());
				entity.setEthinicity(personsVO.getEthinicity());
				entity.setIsHappy(personsVO.getIsHappy());
				entity.setTob(personsVO.getTob());
				entity.setDob(personsVO.getDob());
				entity.setImage(personsVO.getImage());

				System.out
						.println("................Persisting data into the database using Entity Bean JPA........");
				entityManager.persist(entity);
				System.out
						.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			} else {
				System.out
						.println("Sorry cannot be processed.......................................");
			}
		} catch (JMSException e) {
			System.err
					.println("%%%%%%%%%%%%COMING FROM JMSEXCEPTION %%%%%%%%%%%%%%%%%%%%%");
			e.printStackTrace();
		}
	}

	public void onException(JMSException e) {
		System.out.println("Coming from onEXCEPTION method" + e);
	}
}
