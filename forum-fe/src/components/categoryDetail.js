import { useEffect } from "react";
import Footer from "./footer";
import Header from "./header";
import { useState } from "react";
import categoryService from "../services/CategoryService";
import { useParams } from "react-router";
const CategoryDetail = () => {
    const {categoryId} = useParams();
    const [category,setCategory] = useState({});
    useEffect(() => {
        categoryService.getCategoryById("/api3/api/v1/category/",categoryId,(response) => {
            setCategory(response.data);
        });
    },[categoryId,category]);
    return(
        <>
        <Header />
            <div className="container" >
                <div className="row">
                    <CategoryDetailHeader title={category.title} description={category.description} />
                    
                </div>
            </div>

        <Footer />
        </>
    )
}
const CategoryDetailHeader = ({title,description}) => {
    return (<> 
    <div className="col-md-12 text-center border border-black mt-5 mb-5 pt-5 pb-5">
        <h1 className="display-1">{title}</h1>
        <p className="text-lead">{description}</p>
    </div>
    </>);
}
export default CategoryDetail;