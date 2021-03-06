<br />
<br />
<br />
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<div class="container">
<div class="container">

	<div class="row">


		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>

		</div>


		<div class="col-md-9">

			<div class="row">

				<div class="col-lg-12">
					<c:if test="${userClickAllProducts == true}">
						<script>
							window.categoryId = '';
						</script>

						<ol class="breadcrumb">

							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">All Products</li>

						</ol>
					</c:if>

					<c:if test="${userClickCategoryProduct == true}">
						<script>
							window.categoryId = '${category.id}';
						</script>
						<ol class="breadcrumb">

							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">Category</li>
							<li class="breadcrumb-item active">${category.name}</li>

						</ol>
					</c:if>

				</div>

			</div>

			<div class="col-sm-12">


				<table id="productTable"
					class="table table-condensed table-striped table-hover">

					<thead>
						<tr>
						    <th>Code</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Unit Price</th>
							<th>Available Quantity</th>
							<th>Id</th>
							<th></th>
						</tr>
					</thead>

				</table>
			</div>


		</div>

	</div>



</div>