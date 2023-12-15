<%@page import="java.io.IOException"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display Data</title>
</head>
<body>

<h2>Registered Users</h2>

<%
    String filePath = "D://user.txt"; // Replace with the actual file path

    try {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;

        // Start table
%>
        <table border="1">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Gender</th>
                <th>Caste</th>
                <th>Email</th>
            </tr>
<%
        while ((line = br.readLine()) != null) {
            // Parse each line and extract data
            String[] data = line.split(": ");
            if (data.length == 2) {
                String key = data[0];
                String value = data[1];

                // Display data in table rows
                if (key.equals("Firstname")) {
%>
                    <tr>
                        <td><%= value %></td>
<%
                } else if (key.equals("LastName")) {
%>
                        <td><%= value %></td>
<%
                } else if (key.equals("Gender")) {
%>
                        <td><%= value %></td>
<%
                } else if (key.equals("Caste")) {
%>
                        <td><%= value %></td>
<%
                } else if (key.equals("Email")) {
%>
                        <td><%= value %></td>
                    </tr>
<%
                }
            }
        }

        br.close();
%>
        </table>
<%
    } catch (IOException e) {
        e.printStackTrace();
%>
        <p>Error reading file: <%= e.getMessage() %></p>
<%
    }
%>

</body>
</html>
