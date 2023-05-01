import Getaxios from "../utils/Getaxios"
import PostaxiosWithAuth from "../utils/PostAxiosWithAuth"
import Swal from "sweetalert2";
class CategoryService  {
    getAllCategory = (url,callback) => {
        Getaxios(url).then((response) => {
            if(callback){
                callback(response);
            }
        }).catch((error) => {console.log(error)});
    };
    createCategory = (url,data,callback) => {
        PostaxiosWithAuth(url,data).then((response) => {
            if(callback) {
                Swal.fire({
                    title: "OK",
                    text:"OK",
                    icon:"success"
                });
                callback(response);
            }
        }).catch((error) => {
            Swal.fire(
                {
                    title:error.message,
                    text:error.message,
                    icon:"error"
                });
            console.log(error)});
    };
    getCategoryById = (url,categoryId,callback) => { 
        Getaxios(url+categoryId).then((response) => {
            if(callback){
                callback(response);
            } 
        }).catch((error) => console.log(error));
    };
}
const categoryService = new CategoryService();
export default categoryService;