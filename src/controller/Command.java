package controller;


import dao.IFactoryDAO;
import dao.SQLFactoryDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class Command {

    protected static IFactoryDAO factoryDAO = new SQLFactoryDAO();

    public abstract String execute(HttpServletRequest req,
                                   HttpServletResponse res) throws NeedlessTreatmentException;
}
