
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
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span>View Details</a> &#160;';
									str += '<a href="'
											+ window.contextRoot
											+ '/cart/add/'
											+ data
											+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</a>';

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
});


