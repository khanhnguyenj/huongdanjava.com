package com.huongdanjava.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class HelloWorldAction extends Action {

  @Override
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    HelloWorldForm helloWorldForm = (HelloWorldForm) form;
    helloWorldForm.setMessage("Hello World from Huong Dan Java");

    return mapping.findForward("success");
  }

}
