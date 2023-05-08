import { useEffect,useState } from "react";
import profileService from "../services/ProfileService";

const Author = ({userId}) => {
    const [user,setUser] = useState({});
    useEffect(() => {
        profileService.getProfileByUserId("/api2/api/v1/profile/",userId,(response) => {
            setUser(response.data);
        })
    },[userId])
    return (<>
        <div className="row">
        <div className="col-md-12 text-left border border-black mt-2 mb-2 pt-1 pb-1">
            <h1 className="display-1 text-center">Author Information</h1>
            <p className="text-lead">Name : {user.name}</p>
            <p className="text-lead">Surname : {user.surname}</p>
            <p className="text-lead">City : {user.city}</p>
            <p className="text-lead">Country : {user.country}</p>
          </div>
        </div>

    </>);
};
export default Author;