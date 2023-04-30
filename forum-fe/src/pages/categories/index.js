import { useEffect, useState } from "react";
import Footer from "../../components/footer";
import Header from "../../components/header";
import categoryService from "../../services/CategoryService";

const Categories = () => {
    const [categories,setCategories] = useState([]);
    useEffect(() => {
        categoryService.getAllCategory("http://localhost:8083/api/v1/category/listCategory",(response) => {
            setCategories([
                response.data
            ])
        })
    });
    const categoryList = categories.map((category,key) => {
        return <li key={key}>{category.title}</li>
    })
    
    return (
        
        <>
        <Header />
        {categoryList}
        <Footer />
        </>
    );
}

export default Categories;