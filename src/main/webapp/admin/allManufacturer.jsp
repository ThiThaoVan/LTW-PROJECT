<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Tất cả nhà sản xuất</title>

  <!-- Bootstrap  -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

  <!-- jQuery  -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.1/css/all.min.css"/>

  <!-- Google Icon -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined"/>

  <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/admin/styleAllManufacturer.css"/>

</head>
<body class="dark-theme">
<jsp:include page="header-admin.jsp"></jsp:include>

<div id="main-content">
  <div class="main-container">
    <div class="header">
      <h1>Danh sách nhà sản xuất</h1>
    </div>
    <div id="all-user-container">
      <a class="btn btn-primary btn-customize px-5 py-2 mb-2"
         href="<%=request.getContextPath()%>/admin/AddManufacturer" role="button">Thêm</a>

      <table id="myTable" class="display" style="width:100%">
        <thead>
        <tr>
          <th>STT</th>
          <th>Tên nhà cung cấp</th>
          <th>Thương hiệu</th>
          <th>Xuất xứ</th>
          <th>Nơi sản xuất</th>
          <th>Màu sắc</th>
          <th>Chất liệu</th>
          <th>Khối lượng</th>
          <th>Kích thước</th>
          <th>Best Seller</th>
          <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listManu}" var="m" varStatus="i">
          <tr>
            <td>${i.index + 1}</td>
            <td>${m.supplierName}</td>
            <td>${m.brand}</td>
            <td>${m.brandOrigin}</td>
            <td>${m.manufactureLocation}</td>
            <td>${m.color}</td>
            <td>${m.material}</td>
            <td>${m.weight} kg</td>
            <td>${m.dimensions}</td>
            <td>
              <c:choose>
                <c:when test="${m.bestSeller}">✔️</c:when>
                <c:otherwise>❌</c:otherwise>
              </c:choose>
            </td>
            <td>
              <a class="btn btn-success btn-sm" href="<%=request.getContextPath()%>/admin/edit-manufacturer?manuID=${m.manuID}">Sửa</a>

              <a class="btn btn-danger btn-sm" href="<%=request.getContextPath()%>/admin/delete-manufacturer?manuID=${m.manuID}" onclick="return confirmDelete();">Xoá</a>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>

    </div>
  </div>
</div>

<script>
  function confirmDelete() {
    return confirm("Bạn có chắc chắn muốn xoá nhà sản xuất này?");
  }
</script>
</body>
</html>
