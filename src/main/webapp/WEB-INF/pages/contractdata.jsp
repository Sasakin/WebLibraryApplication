<%@ include file="taglibs.jsp" %>

<html>
<head>
  <title>Contract Data</title>

  <style type="text/css">
    .tg {
      border-collapse: collapse;
      border-spacing: 0;
      border-color: #ccc;
    }

    .tg td {
      font-family: Arial, sans-serif;
      font-size: 14px;
      padding: 10px 5px;
      border-style: solid;
      border-width: 1px;
      overflow: hidden;
      word-break: normal;
      border-color: #ccc;
      color: #333;
      background-color: #fff;
    }

    .tg th {
      font-family: Arial, sans-serif;
      font-size: 14px;
      font-weight: normal;
      padding: 10px 5px;
      border-style: solid;
      border-width: 1px;
      overflow: hidden;
      word-break: normal;
      border-color: #ccc;
      color: #333;
      background-color: #f0f0f0;
    }

    .tg .tg-4eph {
      background-color: #f9f9f9
    }
  </style>

</head>
<body>
<h1>Contract Details</h1>

<table class="tg">
  <tr>
    <th width="80">ID</th>
    <th width="120">Title</th>
    <th width="120">Author</th>
   <%-- <th width="120">Price</th>--%>
  </tr>
  <tr>
    <td>${contract.id}</td>
    <td>${contract.number}</td>
    <td>${contract.date}</td>
    <%--<td>${book.price/100}${book.price%100}</td>--%>
    <%--<p><img src="/resources/book_img/${book.book_image}"
             width="240" height="232" ></p>--%>
  </tr>
</table>
</body>
</html>