 
package com.codinggyd.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codinggyd.bean.Article;
import com.codinggyd.service.IArticleService;
 
 
@Controller
public class MineController {
	
	@Qualifier("articleServiceImpl")
	@Autowired
	private IArticleService service;
	
	final Logger logger = LoggerFactory.getLogger(getClass());

	private static final String PATTERN = "yyyy-MM-dd HH:mm.ss.SSS";
	@RequestMapping(value="/update",method = { RequestMethod.GET, RequestMethod.POST })
	public String update(HttpServletRequest request,HttpServletResponse response) {
		
		Article articles = new Article();
		articles.setTitle(request.getParameter("title"));
		articles.setContent(request.getParameter("content"));
		articles.setHtmlContent(request.getParameter("htmlContent"));
		articles.setDescs(request.getParameter("descs"));
		articles.setUpdatetime(DateUtils.formatDate(new Date(), PATTERN));
		articles.setReadingcount(0);
		articles.setType("0");
		service.updateArticle(articles);
		return "success";
	}

  
}
