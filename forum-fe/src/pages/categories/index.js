import { useEffect, useState } from "react";
import Footer from "../../components/footer";
import Header from "../../components/header";
import categoryService from "../../services/CategoryService";
import Category from "../../components/category";
const Categories = () => {
    const [categories,setCategories] = useState([]);
    useEffect(() => {
        categoryService.getAllCategory('/api3/api/v1/category/listCategory',(response) => {
                        console.log(response.data);
                        setCategories(response.data);
        })
        
    },[]);
    const categoryList = categories.map((category,key) => {
        return <Category id={category.id} key={key} title={category.title} description={category.description} />
    })
    
    return (
        <>
        <Header />
    
            <div className="container">
                <button className="btn btn-lg btn-success m-3" >NEW CATEGORY</button>
               {categoryList}
            </div>
        <Footer />
        </>
    );
}

export default Categories;