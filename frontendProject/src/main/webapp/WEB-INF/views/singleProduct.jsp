<div class="container">

	<!-- Breadcrumb -->
	<div class="row">

		<div class="col-xs-12">

         	<ol class="breadcrumb">

				<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>                   <!-- for home page -->
				<li class="breadcrumb-item"><a href="${contextRoot}/show/all/products">Products</a></li>  <!-- for all products -->
				<li class="breadcrumb-item active">${product.name}</li>                                   <!-- for single product -->

			</ol>

        </div>


	</div>
	<!-- display the product image -->
	<div class="row">

		<div class="col-xs-12 col-sm-6">

			<div class="thumbnail">

				<img src="${images}/${product.code}.jpg" class="img img-responsive" />

			</div>

		</div>

   <!--product details  -->
 
       <div class="col-xs-12 col-sm-6">

			<h3>${product.name}</h3>
			<hr />

			<p>${product.description}</p>
			<hr />
            
            <h4>
				Price: <strong> &#8377; ${product.unitPrice} /-</strong>
			</h4>

			<c:choose>
               <c:when test="${product.quantity < 1}">

					<h6>
						Qty. Available: <span style="color: red">Out of Stock!</span>
					</h6>

				</c:when>
				<c:otherwise>

					<h6>Qty. Available: ${product.quantity}</h6>

				</c:otherwise>

			</c:choose>

			<hr />

			<c:choose>
				
				<c:when test="${product.quantity < 1}">
				
					<a href="javascript:void(0)" class="btn btn-success disabled"><strike>
					<span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</strike></a>
					
				</c:when>
				<c:otherwise>				
				
				<a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success">
				<span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart</a>
						
				</c:otherwise>
			
			</c:choose>
			</a> <a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>

		</div>

	</div>


</div>



</div>
© 2021 GitHub, Inc.
