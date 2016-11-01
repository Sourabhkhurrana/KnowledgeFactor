package nougatstudio.knowledgefactor;

/**
 * Created by soura on 01-11-2016.
 */

public class CategoryValues {

    private String technologyName;
    private String CategoryName;
    private String SubCategoryName;
    private int subCategories;

    public CategoryValues() {

    }
    public CategoryValues(String CategoryName, int SubCategories){
        this.subCategories = SubCategories;
        this.CategoryName = CategoryName;
    }

    public String getTechnologyName(){
        return technologyName;
    }
    public void setTechnologyName(String technologyName){
        this.technologyName = technologyName;
    }

    public String getCategoryName(){
        return CategoryName;
    }
    public void setCategoryName(String CategoryName){
        this.CategoryName = CategoryName;
    }

    public String getSubCategoryName(){
        return SubCategoryName;
    }
    public void setSubCategoryName(String SubCategoryName){
        this.SubCategoryName = SubCategoryName;
    }

    public int getSubCategories(){
        return subCategories;
    }
    public void setSubCategories(int subCategories){
        this.subCategories = subCategories;
    }


}
