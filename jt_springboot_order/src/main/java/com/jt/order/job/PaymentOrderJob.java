package com.jt.order.job;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.jt.order.mapper.OrderMapper;

public class PaymentOrderJob extends QuartzJobBean{

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		//获取spring的上下文对象applicationContext
		ApplicationContext applicationContext=(ApplicationContext) 
				context.getJobDetail().getJobDataMap().
				get("applicationContext");
		//利用上下文对象,获取能够操作order表格的对象OrderMapper
		OrderMapper orderMapper = applicationContext.getBean(OrderMapper.class);
		orderMapper.paymentOrder(
				new Date(System.currentTimeMillis()-1000*60*60*24));//传递一个超时1天的值
	}

}





