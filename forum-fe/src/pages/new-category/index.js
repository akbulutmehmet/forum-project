import { useEffect, useState } from "react";
import Footer from "../../components/footer";
import Header from "../../components/header";
import categoryService from "../../services/CategoryService";
const NewCategory = ({GlobalState}) => {
    const [category,setCategory] = useState({});
    const {userId} = GlobalState;
    const onChangeTitle = (event) => {
        setCategory({
            ...category,
            title:event.target.value
        });
    };
    const onChangeDescription = (event) => {
        setCategory({
            ...category,
            description:event.target.value
        });
    };
    useEffect(() => {
        setCategory({
            ...category,
            "userId":userId
        });
    },[])
    const onClickBtn = () => {
        categoryService.createCategory("/api3/api/v1/category/createCategory",JSON.stringify(category),(response) =>{
            if(response.status === 200) {
                setTimeout(() => {
                window.location.href = "/categories";
                },1000)
            }
            console.log(response);
        });
    };
    return <>
    <Header />
        <div className="container mt-5 mb-5 pt-1 pb-1 ">
            <div className="row justify-content-center">
                <div className="col-md-8">
                    <div className="form-gruop mt-3">
                        <label htmlFor="title">Title</label>
                        <input className="form-control" id="title" type="text" onChange={onChangeTitle}/>
                    </div>
                    <div className="form-gruop mt-3">
                        <label htmlFor="description">Description</label>
                        <input className="form-control" id="description" type="text" onChange={onChangeDescription}/>
                    </div>
                    <div className="form-gruop mt-3">
                        <button onClick={onClickBtn} className="btn btn-lg btn-success">CREATE</button>
                    </div>
                </div>
            </div>
        </div>
    <Footer />
    </>
}
export default NewCategory;