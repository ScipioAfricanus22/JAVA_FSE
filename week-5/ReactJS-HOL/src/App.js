import React from 'react';
import './App.css';

// Exported data arrays mirroring the specifications
export const books = [
  { id: 101, bname: 'Master React', price: 670 },
  { id: 102, bname: 'Deep Dive into Angular 11', price: 800 },
  { id: 103, bname: 'Mongo Essentials', price: 450 }
];

const courses = [
  { id: 1, cname: 'Angular', date: '4/5/2021' },
  { id: 2, cname: 'React', date: '6/3/20201' } // Kept string year format exactly matching the image typo
];

const blogs = [
  { id: 501, title: 'React Learning', author: 'Stephen Biz', text: 'Welcome to learning React!' },
  { id: 502, title: 'Installation', author: 'Schewzdenier', text: 'You can install React from npm.' }
];

function App() {
  // Rendering element variables exactly as required in the hints block
  const bookdet = (
    <ul>
      {books.map((book) => (
        <div key={book.id}>
          <h3>{book.bname}</h3>
          <h4>{book.price}</h4>
        </div>
      ))}
    </ul>
  );

  const coursedet = (
    <ul>
      {courses.map((course) => (
        <div key={course.id}>
          <h3>{course.cname}</h3>
          <h4>{course.date}</h4>
        </div>
      ))}
    </ul>
  );

  const content = (
    <ul>
      {blogs.map((blog) => (
        <div key={blog.id}>
          <h3>{blog.title}</h3>
          <h4>{blog.author}</h4>
          <p>{blog.text}</p>
        </div>
      ))}
    </ul>
  );

  return (
    <div className="dashboard-container">
      {/* Course Details column */}
      <div className="mystyle1">
        <h1>Course Details</h1>
        {coursedet}
      </div>

      {/* Book Details column */}
      <div className="st2">
        <h1>Book Details</h1>
        {bookdet}
      </div>

      {/* Blog Details column */}
      <div className="v1">
        <h1>Blog Details</h1>
        {content}
      </div>
    </div>
  );
}

export default App;
