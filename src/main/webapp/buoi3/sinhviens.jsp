<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--JSTL--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="">
    Tên: <input name="ten"/>
    <button type="submit">Search</button>
</form>
<br/>
<button><a href="/sinh-vien/view-add">Add Student</a></button>
<table>
    <tr>
        <th>STT</th>
        <th>MSSV</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Địa chỉ</th>
        <th>Giới tính</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <%--    // for(SinhVien sv: lists)--%>
    <c:forEach items="${sinhViens}" var="sv" varStatus="viTri">
        <tr>
                <%-- Lay duoc VI tri Cua mang--%>
            <td>${viTri.index}</td>
            <td>${sv.mssv}</td>
            <td>${sv.ten}</td>
            <td>${sv.tuoi}</td>
            <td>${sv.diaChi}</td>
            <td>${sv.gioiTinh}</td>
            <td>
                <button><a href="/sinh-vien/remove?ma=${sv.mssv}">Delete</a></button>
                <button><a href="/sinh-vien/detail?id1=${sv.mssv}">Detail</a></button>
                <button><a href="/sinh-vien/view-update?id=${sv.mssv}">Update</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
