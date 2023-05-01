import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Link } from 'react-router-dom';
const Navmenu = () => {

    return (
        <>
     <Navbar bg="primary" variant="dark">
        <Container>
          <Link className='navbar-brand' to="/">Forum Project</Link>
          <Nav className="me-auto">
            <Link className="nav-link" to="/categories">Categories</Link>
            <Link className="nav-link" to="/profile">Profile</Link>
          </Nav>
        </Container>
      </Navbar>
        </>

)
}

export default Navmenu;