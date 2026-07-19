import './App.css';
import BookDetails from './Components/BookDetails';
import BlogDetails from './Components/BlogDetails';
import CourseDetails from './Components/CourseDetails';

function App() {
  return (
    <div className="container">
      <div className="section">
        <CourseDetails />
      </div>

      <div className="section">
        <BookDetails />
      </div>

      <div className="section">
        <BlogDetails />
      </div>
    </div>
  );
}

export default App;