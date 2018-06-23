package com.simplejavaee.webaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplejavaee.dao.DAOFactory;
import com.simplejavaee.dao.UtilDAO;
import com.simplejavaee.model.NameM;

public class SearchNameWebAction {

	public boolean run(HttpServletRequest request, HttpServletResponse response) {
    	try {

    		System.out.println(" ############## SearchNameWebAction ###################");
    		
    		String yourName = request.getParameter("yourName");
    		System.out.println(" ################################################################# : yourName : " + yourName);
    		
    		NameM nameM = (NameM) request.getSession().getAttribute("nameM");
    		if (nameM == null) {
    			System.out.println(" ################################################################# : Init nameM in sessionBean");
    			nameM = new NameM();
    			request.getSession().setAttribute("nameM", nameM);
    		}
    		
    		
    		UtilDAO dao = DAOFactory.getUtilDAO();
    		yourName = dao.loadUserM(yourName);

    		System.out.println(" ################################################################# : yourName from DB : " + yourName);
    		nameM.setName(yourName);
    		
    		
    		
//    		TreeFormHandler treeFormHandler = (TreeFormHandler)getRequest().getSession().getAttribute("treeFormHandler");
//    		if(treeFormHandler==null){
//    			log.error("treeFormHandler is null");
//    			treeFormHandler = new TreeFormHandler();
//    			getRequest().getSession().setAttribute("treeFormHandler", treeFormHandler);
//    		}
//    		
//    		ParameterTreeM parameterTreeM = treeFormHandler.getParameterTreeM();
//    		if(parameterTreeM==null){
//    			log.error("parameterTreeM is null");
//    			parameterTreeM = new ParameterTreeM();
//    			treeFormHandler.setParameterTreeM(parameterTreeM);
//    		}
//    		treeFormHandler.setActiveDecision(DefaultVariable.defaultString(getRequest().getParameter("decision")));
//    		
//			log.debug(" ########## " + parameterTreeM.getTableName());
//			log.debug(" ########## " + parameterTreeM.getTreeCode());
//			log.debug(" ########## " + treeFormHandler.getActiveDecision());
//
//			/* Get parameter from front-end for keep in session */
//			log.debug(" ########## status No : " + getRequest().getParameter("statusN"));
//			log.debug(" ########## status Yes : " + getRequest().getParameter("statusY"));
//			parameterTreeM.setStatusNo(DefaultVariable.defaultString(getRequest().getParameter("statusN")));
//			parameterTreeM.setStatusYes(DefaultVariable.defaultString(getRequest().getParameter("statusY")));
//		
//			MasterSetupDAO dao = CarpassDAOFactory.getMasterSetupDAO();
//			treeFormHandler.setNodeList( dao.searchNodeList());
////														parameterTreeM.getTableName(),
////														parameterTreeM.getTreeCode(),
////														treeFormHandler.getActiveDecision()) );
//			
		}catch(Exception e){
			return false;
		}
			
		return true;
	}
	
	
}
