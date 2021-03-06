package de.novatec.bpm.example.pizza;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named
public class LoggerDelegate implements JavaDelegate {

	private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());

	@Inject
	private ServiceCall serviceCall;

	public void execute(DelegateExecution execution) throws Exception {

		LOGGER.info("\n\n  ... LoggerDelegate invoked by " + "processDefinitionId=" + execution.getProcessDefinitionId()
				+ ", activtyId=" + execution.getCurrentActivityId() + ", activtyName='"
				+ execution.getCurrentActivityName() + "'" + ", processInstanceId=" + execution.getProcessInstanceId()
				+ ", businessKey=" + execution.getProcessBusinessKey() + ", executionId=" + execution.getId()
				+ " \n\n");

		String respose = serviceCall.callService();
		LOGGER.info(respose);
	}
}
