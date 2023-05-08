import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Link, useNavigate } from 'react-router-dom';
const Navmenu = () => {
    const navigate = useNavigate();
    const onClickBtn = () => {
      sessionStorage.clear();
      navigate("/login");
    }
    return (
        <>
     <Navbar  bg="primary" variant="dark">
        <Container>
          <Link className='navbar-brand' to="/">Forum Project</Link>
          <Nav className="me-auto">
            <Link className="nav-link" to="/categories">Categories</Link>
            <Link className="nav-link" to="/profile">Profile</Link>
            <button onClick={onClickBtn} className='nav-link btn' >Logout</button>
          </Nav>
        </Container>
      </Navbar>
        </>

)
}

export default Navmenu;