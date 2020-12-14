package com.ruchi.backendProject.daoimpl;

import java.util.List;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

import com.ruchi.backendProject.dao.CategoryDAO;
import com.ruchi.backendProject.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOimpl implements CategoryDAO
{
  private static  List<Category> categories = new ArrayList<>();
	
  static
		
  {         //1st category
			Category ct = new Category();
			ct.setId(1);
			ct.setName("Phone");
			ct.setDesc("Some Description");
			ct.setImageurl("CAT_1.jpg");
			categories.add(ct); 
			
			//2nd category
		    ct = new Category();
			ct.setId(2);
	        ct.setName("Camera");
			ct.setDesc("Some Description");
			ct.setImageurl("CAT_2.jpg");
			categories.add(ct);
			
			//3rd category
		    ct = new Category();
			ct.setId(3);
			ct.setName("Tv");
			ct.setDesc("Some Description");
			ct.setImageurl("CAT_3.jpg");
			categories.add(ct);
			
			
		}

	public List<Category> categoryList()
	{
		
		return categories;
	}

	@Override
	public List<Category> categorylist() {
		// TODO Auto-generated method stub
		return null;
	}
}
