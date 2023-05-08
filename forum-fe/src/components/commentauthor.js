import { useState,useEffect } from "react";
import profileService from "../services/ProfileService";
const Commentauthor = ({userId}) => {
    const [user,setUser] = useState({});
    useEffect(() => {
        profileService.getProfileByUserId("/api2/api/v1/profile/",userId,(response) => {
            setUser(response.data);
        })
    },[userId])
    return (
        <div className="col-md-12 border border-black" >
        <p>{user.name}  {user.surname}</p>

        </div>
    );
}
export default Commentauthor;