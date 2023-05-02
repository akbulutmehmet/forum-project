import { useEffect } from "react";
import Footer from "./footer";
import Header from "./header";
import { useState } from "react";
import categoryService from "../services/CategoryService";
import { useParams } from "react-router";
import Post from "./post";
const CategoryDetail = () => {
    const {categoryId} = useParams();
    const [category,setCategory] = useState({});
    const [posts,setPosts] = useState([]);
    useEffect(() => {
        categoryService.getCategoryById("/api3/api/v1/category/",categoryId,(response) => {
            setCategory(response.data);
            setPosts(response.data.posts);
        });
    },[categoryId]);
    const postList = posts.map((post,key) => {
        return <Post key={key} title={post.title} id={post.id} />;
    });
    return(
        <>
        <Header />
            <div className="container" >
                <div className="row">
                    <CategoryDetailHeader title={category.title} description={category.description} />
                    {postList}
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