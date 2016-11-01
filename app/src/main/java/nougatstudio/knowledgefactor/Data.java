package nougatstudio.knowledgefactor;

/**
 * Created by soura on 24-10-2016.
 */

public class Data {
    public static boolean isAtHome;
    private String technologyName;
    private String CategoryName;
    private int CategoriesImages;
    private int Color;
    public static int preparationNo = 0;

    public Data(){

    }
    public static String []Aptitude = {"Aptitude 1","Aptitude 2","Aptitude 3","Aptitude 4","Aptitude 5","Aptitude 6"};

    public static String[] Technology = {"Java Developer","Web Developer","Mongo DB","C++ ","C#","Web Developer","Java Developer"};

    //public static String[] Category = {"Aptitude","Reasoning","Math","Company","Interviews"};

    public static int[] CategoryImages = {R.mipmap.share, R.mipmap.rupee,R.mipmap.share,R.mipmap.rupee,R.mipmap.rupee,};

    public static int[]CategoryColor = {R.color.Amber, R.color.LightBlue,R.color.Brown,
            R.color.Grey,R.color.colorAccent,R.color.Purple, R.color.Teal,R.color.Red,
            R.color.Pink, R.color.Amber,R.color.LightGreen,R.color.DeepPurple,R.color.DeepOrange,
            R.color.Cyan, R.color.Amber,R.color.Pink,R.color.Brown,R.color.Green};


    public Data(String technologyName){
        this.technologyName = technologyName;
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

    public int getColor(){
        return Color;
    }
    public void setColor(int Color){
        this.Color = Color;
    }

    public int getCategoriesImages(){
        return CategoriesImages;
    }
    public void setCategoriesImages(int CategoriesImages){
        this.CategoriesImages = CategoriesImages;
    }



}
