
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>List</title>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <!-- 기존의 <h1>Header</h1> -->
        <div class="row">
            <div class="col">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="#">Navbar</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                            <div class="navbar-nav">
                                <a class="nav-link active" aria-current="page" href="#">Home</a>
                                <a class="nav-link" href="#">Features</a>
                                <a class="nav-link" href="#">Pricing</a>
                                <a class="nav-link disabled">Disabled</a>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <!-- header end -->
        <!-- 기존의 <h1>Header</h1>끝 -->
        <div class="row content">
            <div class="col">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Search </h5>
                        <form action="/product/list" method="get">
                            <div class="mb-3">
                                상품 이름
                                <input type="text"  name="pname" class="form-control" value ='<c:out value="${pname}"/>' >
                            </div>
                            <div class="input-group mb-3">
                                <div class="float-end">
                                    <button class="btn btn-primary" type="submit">Search</button>
                                    <button class="btn btn-info clearBtn" type="reset">Clear</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
        </div>

        <div class="row content">
            <div class="col">
                <div class="card">
                    <div class="card-header">
                        상품 목록♥
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">상품 목록</h5>
                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="fcol">상품 번호</th>
                                <th scope="col">상품 이름</th>
                                <th scope="col">상품 가격</th>
                                <th scope="col">재고 수량</th>
                                <th scope="col">수정</th>
                                <th scope="col">삭제</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${dtoList}" var="dto">
                                <tr>
                                    <th scope="row"><c:out value="${dto.pno}"/></th>
                                    <td>
                                        <a href="/product/read?pno=${dto.pno}&${pageRequestDTO.link}" class="text-decoration-none" data-id="${dto.pno}" >
                                            <c:out value="${dto.pname}"/>
                                        </a>
                                    </td>
                                    <td><c:out value="${dto.price}"/></td>
                                    <td><c:out value="${dto.count}"/></td>
                                    <td>
                                        <form action="/product/modify">
                                            <input type="hidden" name="pno" value="${dto.pno}">
                                            <button type="submit">수정</button>
                                        </form>
                                    </td>
                                    <td>
                                        <form action="/product/remove" method="post">
                                            <input type="hidden" name="pno" value="${dto.pno}">
                                            <button type="submit">삭제</button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>

                        </table>

                        <div class="float-end">
                            <ul class="pagination flex-wrap">
                                <c:if test="${responseDTO.prev}">
                                    <li class="page-item">
                                        <a class="page-link" data-num="${responseDTO.start -1}">Previous</a>
                                    </li>
                                </c:if>

                                <c:forEach begin="${responseDTO.start}" end="${responseDTO.end}" var="num">
                                    <li class="page-item ${responseDTO.page == num? "active":""} ">
                                        <a class="page-link"  data-num="${num}">${num}</a></li>
                                </c:forEach>

                                <c:if test="${responseDTO.next}">
                                    <li class="page-item">
                                        <a class="page-link"  data-num="${responseDTO.end + 1}">Next</a>
                                    </li>
                                </c:if>
                            </ul>

                        </div>

                        <script>

/* document.querySelector(".pagination").addEventListener("click", function (e) {
        e.preventDefault()
        e.stopPropagation()

        const target = e.target


        if(target.tagName !== 'A') {
            return
        }
        const num = target.getAttribute("data-num")

        self.location = `/product/list?page=\${num}` //백틱(` `)을 이용해서 템플릿 처리
    },false)*/

    document.querySelector(".pagination").addEventListener("click", function (e) {
        e.preventDefault()
        e.stopPropagation()

        const target = e.target

        if(target.tagName !== 'A') {
            return
        }
        const num = target.getAttribute("data-num")

        const formObj = document.querySelector("form")

        formObj.innerHTML += `<input type='hidden' name='page' value='\${num}'>`

        formObj.submit();

    },false)



    document.querySelector(".clearBtn").addEventListener("click", function (e){
        e.preventDefault()
        e.stopPropagation()

        self.location ='/product/list'

    },false)


                        </script>

                    </div>
                    <div class="card-button">
                        <form action="/product/register">
                            <button type="submit">상품 추가</button>
                        </form>
                    </div>

                </div>
            </div>
        </div>

    </div>
    <div class="row content">
    </div>
    <div class="row footer">
        <!--<h1>Footer</h1>-->

        <div class="row   fixed-bottom" style="z-index: -100">
            <footer class="py-1 my-1 ">
                <p class="text-center text-muted">Footer</p>
            </footer>
        </div>

    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>