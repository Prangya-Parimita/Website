
$(function() {

	switch (menu) 
	{

	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Manage Product':
		$('#manageProduct').addClass('active');
		break;
	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		break;
	}
 
	
	
	var $table = $('#productTable');

	if ($table.length)
	{
		var jsonUrl = '';
		if (window.categoryId == '') 
		{
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} 
		else 
		{
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/product';
		}

		$table
				.DataTable({
					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3', '5', '10', 'ALL' ] ],
							
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					       },
					columns : [
							{
								data : 'code',
								bSortable : false,
								mRender : function(data, type, row)
								{
                                  return '<img src="' + window.contextRoot
											          + '/rs/images/' + data
											          + '.jpg" class="dataTableImg"/>';

								}
							
							},

							{
								data : 'name'
							},
							
							{
								data : 'brand'
							},
							
							{
								data : 'unitPrice',
								mRender : function(data, type, row)
								{
								  return '&#8377; ' + data
								}
							},
							
							{
								data : 'quantity',
								mRender : function(data, type, row)
								{

									if (data < 1) 
									{
										return '<span style="color:red">Out of Stock!</span>';
									}

									return data;

								}
							},
							
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) 
								{

									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span>VIEW</a> &#160;';

									if (userRole !== 'ADMIN')
									{
										if (row.quantity < 1)
										{
											str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
										} else
										    {
											str += '<a href="'
												+ window.contextRoot
												+ '/cart/add/'
												+ data
												+ '/product" class="btn btn-success"><i class="fa fa-shopping-cart"></i></a>';

											 }
									} else {
										str += '<a href="'
												+ window.contextRoot
												+ '/manage/'
												+ data
												+ '/product" class="btn btn-warning"><span class="glyphicon glyphicon-pencil">EDIT</span></a>';
									}

									return str;

									
									}      
								     
							},
					]
				});
	    }
	
	
	
	
	var $table = $('#adminProductsTable');

	if ($table.length) 
	{

		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

	
	   $table
	   .DataTable({
		lengthMenu : [ [ 10, 20, 30, -1 ],
				[ '10', '20', '30', 'ALL' ] ],
		pageLength : 20,
		ajax : {
			url : jsonUrl,
			dataSrc : ''
		       },
		columns : [
			        {
			 	      data : 'id'
			        },
			        
					{
					  data : 'code',
					  bSortable : false,
					  mRender : function(data, type, row)
					     {
                                return '<img src="' + window.contextRoot
								          + '/rs/images/' + data
								          + '.jpg" class="adminDataTableImg"/>';

					     }
				    },

				   {
					 data : 'name'
			       },
				
				   {
					 data : 'brand'
				   },
				   
				   {
						 data : 'quantity',
						 mRender : function(data, type, row)
					         {

							      if (data < 1) 
							       {
								        return '<span style="color:red">Out of Stock!</span>';
							       }

							      return data;

						     }
					   },
				
				   {
					 data : 'unitPrice',
					 mRender : function(data, type, row)
				         {
					           return '&#8377; ' + data
					     }
			   	   },
			   	   
			   	   {
					 data : 'active',
					 bSortable : false,
					 mRender : function(data, type, row) 
						 {
							  var str = '';
							  if(data) 
							      {											
								  str += '<label class="switch"> <input type="checkbox" value="'+row.id+'" checked="checked">  <div class="slider round"> </div></label>';
								
							      }
							  else 
							      {
								  str += '<label class="switch"> <input type="checkbox" value="'+row.id+'">  <div class="slider round"> </div></label>';
							      }
							
							  return str;
						 }
			   	   },
				
				   
				
				   {
					 data : 'id',
					 bSortable : false,
					 mRender : function(data, type, row) 
					     {

						     var str = '';
						     str += '<a href="'
								+ window.contextRoot
								+ '/manage/'
								+ data
								+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';

						return str;
					      }      
					     
				   },
		],
		
		initComplete : function() //after completed loading  the data/value run the fn
		{
			var api = this.api();
			$('.switch input[type = "checkbox"]').on('change',function()
					{
		                var checkbox = $(this);                                    //extracting the instance of type = "checkbox" in check variable
						var checked = checkbox.prop('checked');                    // etracting the checked proprty
						var msg = (checked) ? 'You want to activate the product?'  // passing the checked property into msg
								        : 'You want to deactivate the product?';
						var value = checkbox.prop('value');                        // saved the value property into value
						console.log(value);                                        //this print the value on html consol
						bootbox.confirm
						({
							size : 'medium',                            
							title : 'Product Activation/Deactivation',             // setting the title of checkbox
							message : msg,
							callback : function(confirmed)                         // if property is conform
							{
								if (confirmed) 
								{
									var activeurl = window.contextRoot + '/manage/product/'+checkbox.prop('value')+'/activation';
									$.post(activeurl , function(data)  // to include the url
										{
										   bootbox.alert
										   ({
											size : 'medium',
											title : 'Information',
											message : data,

										   });
									})

								}
								else
								   {
									checkbox.prop('checked', !checked);
								   }
							 }
									  
								});
									
					  }
					)
		     }	
});

	};	
	
	/*--------------JQUERY VALIDATION-----------------*/
	
	$categoryForm = $('#categoryForm');
	
	if($categoryForm.length) // form is active or not
	{
		
		$categoryForm.validate   // validate and has 3 parameter
			({
				
				rule:            //codition for validation
				{
					name:{
						   required: true, // cant b blank
			               minlength:1,
					     }
				},
			
			    message :
			    {
			    	name:{
						required :"cannot leave empty" ,
						minlength :"Minimum length should be 2 characters" ,
					},
					
					desc:{
						required :" cannot leave description empty" ,
						minlength :"Minimum length should be 10 characters" ,
					}	
			    },
			         
			    errorElement :"em",  // where it has defined
				errorPlacement : function(error, element) // from sf error
				{
					
					error.addClass('help-block'); // css class
					
					error.insertAfter(element);
					
				}
				
			        	 
			            
			})
	   }
	
	
	
	
	/*--------------JQUERY VALIDATION FOR LOGIN PAGE-----------------*/
	$loginForm = $('#loginForm');

	if ($loginForm.length) {

		$loginForm.validate({
			rules : {
				username :
				{
					required : true,
					email : true

				},
				password : 
				 {
					required : true
				}
			},
			messages : {
				username : {
					required : "Enter your email id!",
					email : "Please enter a valid email id!"
				},
				password : {
					required : "Enter your password!"
					
				}
			},
			errorElement : "em",
			errorPlacement : function(error, element) {
				// Add the 'help-block' class to the error element
				error.addClass("help-block");

				// add the error label after the input element
				error.insertAfter(element);
			}
		}

		);

	}
	
                   //HANDLE REFRESH PAGE
	
	    $('button[name="refreshCart"]').click(function()
			{
	    	var cartLineId = $(this).attr('value'); // etracting the id
			
			var countField = $('#count_' + cartLineId); // etracting the count
			
			var originalCount = countField.attr('value');// checking the original count
			

			var updatedCount = countField.val();     //updated count
		
			if(updatedCount != originalCount) 
			{	
				
				if(updatedCount < 1 || updatedCount > 5) 
				{
					
					countField.val(originalCount);
					bootbox.alert({
							size: 'medium',
							title: 'Error',
							message: 'Product Count should be minimum 1 and maximum 5!'
					});
				}
				else 
				{
					// use the window.location.href property to send the request to the server
					var updateUrl = window.contextRoot + '/cart/' + cartLineId + '/update?count=' + updatedCount;
					window.location.href = updateUrl;
				}
			}
});	
	
			
	    	
});


