package com.rcs.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.scheduler.SchedulerEntry;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.TriggerState;
import com.liferay.portal.kernel.scheduler.TriggerType;
import com.liferay.portal.kernel.scheduler.messaging.SchedulerResponse;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rcs.constants.SchedulerSettingsConstant;

/**
 * Portlet implementation class SchedulerSettings
 */
public class SchedulerSettings extends MVCPortlet {
	private static final Log logger = LogFactoryUtil
			.getLog(TwitterSetting.class);

	private static final String TweetsListener = com.rcs.scheduler.TweetsListener.class
			.getName();

	private Integer JobInterval = 0;

	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		String currentViewPage = renderRequest.getParameter("jspPage");

		getCurrentJob();

		String cron = JobInterval.toString();
		renderRequest.setAttribute(SchedulerSettingsConstant.CRON, cron);

		if (currentViewPage != null && !currentViewPage.equals("")) {
			include(currentViewPage, renderRequest, renderResponse);
		} else {
			include(viewJSP, renderRequest, renderResponse);
		}

	}

	public void startScheduler(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		String cron = actionRequest
				.getParameter(SchedulerSettingsConstant.CRON);

		Integer minutes = Integer.valueOf(cron);

		String portletId = (String) actionRequest
				.getAttribute(WebKeys.PORTLET_ID);

		String description = deleteJob();
		if (description == null) {
			description = SchedulerSettingsConstant.JOBDESCRIPTION;
		}
		boolean success = true;
		if (minutes > 0) {
			success = scheduleJob(actionRequest, portletId, description, minutes);
		}
		if (success == true) {
			SessionMessages.add(actionRequest,
					"schedulerSettings-update-success");
		} else {
			SessionErrors.add(actionRequest,
					"schedulerSettings-update-error");
		}

		getCurrentJob();

		actionResponse.setRenderParameter("jspPage",
				"/html/schedulerSettings/edit.jsp");
		actionRequest.setAttribute(SchedulerSettingsConstant.CRON, cron);

		// returns null in jsp. why?
		// actionResponse.setRenderParameter(SchedulerSettingsConstant.CRON,
		// cron.toString());
	}

	private void getCurrentJob() {
		Integer milliseconds = 0;
		List<SchedulerResponse> scheduledJobs;
		try {
			scheduledJobs = SchedulerEngineHelperUtil.getScheduledJobs();
			for (SchedulerResponse schedulerResponse : scheduledJobs) {
				if (schedulerResponse.getJobName().equals(TweetsListener)) {
					if (schedulerResponse.getJobName().equals(TweetsListener)) {
						logger.info("Available scheduled job: "
								+ schedulerResponse.getJobName() + "\n\t"
								+ schedulerResponse.getDescription());
						// when the job is just started the trigger is null; 
						if (schedulerResponse.getTrigger() != null) {
							logger.info("Trigger content: "
									+ schedulerResponse.getTrigger()
											.getTriggerContent());

							milliseconds = Integer.valueOf(schedulerResponse
									.getTrigger().getTriggerContent()
									.toString());

						}
					}
				}
			}
		} catch (SchedulerException e) {
			logger.warn(e);
		}
		Integer minutes = Integer.valueOf(milliseconds / 60000);
		JobInterval = minutes;
	}

	private String deleteJob() {
		String description = null;
		List<SchedulerResponse> scheduledJobs;
		try {
			scheduledJobs = SchedulerEngineHelperUtil.getScheduledJobs();
			for (SchedulerResponse resp : scheduledJobs) {
				if (resp.getJobName().equals(TweetsListener)) {
					description = resp.getDescription();
					String groupName = resp.getGroupName();
					StorageType storageType = resp.getStorageType();
					SchedulerEngineHelperUtil.getJobState(resp);
					if (SchedulerEngineHelperUtil.getJobState(resp) != TriggerState.UNSCHEDULED) {
						logger.info("Unscheduling :" + TweetsListener);
						SchedulerEngineHelperUtil.unschedule(TweetsListener,
								groupName, storageType);

					}
					logger.info("Deleting :" + TweetsListener);
					SchedulerEngineHelperUtil.delete(TweetsListener, groupName,
							storageType);
				}
			}
		} catch (SchedulerException e) {
			logger.warn(e);
		}
		return description;
	}

	private static boolean scheduleJob(ActionRequest actionRequest,
			String portletId, String description, Integer minutes) {
		boolean succes = false;
		logger.info("Schedule " + TweetsListener);
		SchedulerEntry schedulerEntry = new SchedulerEntryImpl();
		schedulerEntry.setDescription(description);
		schedulerEntry.setEventListenerClass(TweetsListener);
		schedulerEntry.setTimeUnit(TimeUnit.MINUTE);
		schedulerEntry.setTriggerType(TriggerType.SIMPLE);
		schedulerEntry.setTriggerValue(minutes);
		try {
			SchedulerEngineHelperUtil.schedule(schedulerEntry,
					StorageType.PERSISTED, portletId, 0);
			succes = true;
		} catch (SchedulerException e) {
			succes = false;
			logger.warn(e);
		}
		return succes;
	}

	public void init() {
		viewJSP = getInitParameter("view-template");
	}

	protected void include(String path, RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext()
				.getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			logger.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}

	protected String viewJSP;

}
