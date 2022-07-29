
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>

<%@page import="net.sf.jasperreports.engine.*"%>
<%@page import="net.sf.jasperreports.view.JasperViewer"%>

<%@page import="javax.servlet.Servlet"%>
<%@page import="dao.Conexion"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <%
            Conexion con = new Conexion();
            Connection conn = con.getConexion();
            File reportfile = new File(application.getRealPath("reportesJasper/report2.jasper"));
            Map<String, Object> parameter = new HashMap<String, Object>();
            byte[] bytes = JasperRunManager.runReportToPdf(reportfile.getPath(), parameter, conn);
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outputstream = response.getOutputStream();
            outputstream.write(bytes, 0, bytes.length);
            outputstream.flush();
            outputstream.close();
        %>
    </body>
</html>
