# www-lab-week01
# Quản Lý Đăng Nhập
<hr>

- Thông tin bao gồm: account đăng nhập, ngày giờ
đăng nhập, ngày giờ đăng xuất, ghi chú.

- Sử dụng: Servlet Jakarta EE, JSP, CRUD JPA.
  
- Mô tả
  
 > Một trang html hiển thị cửa sổ đăng nhập. Nếu đăng nhập thành công và là quyền admin 
thì hiển thị trang dashboard cho phép quản lý các account khác (bao gồm các quyền thêm, 
xóa, sửa và cấp quyền). Còn không (không phải admin) thì hiển thị thông tin của người 
đăng nhập.
 >
 > Ghi log mỗi lần account đăng nhập, đăng xuất.
> 
-  Entity Relationship Diagram:

  ![ERD](/img/ERD.png)

  -  Class Diagram:
![Class](/img/ClassDiagram.png)

- Trang login
  ![login](img/login.png)
- Login với quyền admin
  - Các quyền của admin
    ![account](img/viewAdmin.png)
  - Quản lý các account
    ![acc](img/viewAcc.png)
  - Xem các log của mỗi account đăng nhập
    ![log](img/viewLog.png)
  - Các chức năng của admin:
    - Thêm 1 Account
    - Xóa 1 Account
  - Login với quyền user
    ![user](img/viewUser.png)
    
    
