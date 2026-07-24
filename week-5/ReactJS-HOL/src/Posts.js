import React, { Component } from 'react';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      error: null
    };
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response failed');
        }
        return response.json();
      })
      .then((data) => {
        // Slice the array down slightly to keep the UI clean
        this.setState({ posts: data.slice(0, 10) });
      })
      .catch((err) => {
        alert('Error parsing data: ' + err.message);
        this.setState({ error: err.message });
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    alert('Lifecycle Boundary Error Caught: ' + error.toString());
    this.setState({ error: error.toString() });
  }

  render() {
    if (this.state.error) {
      return (
        <div style={{ padding: '20px', color: 'red' }}>
          <h2>Something went wrong loading your feed.</h2>
        </div>
      );
    }

    return (
      <div style={{ padding: '20px', maxWidth: '800px', margin: '0 auto', textAlign: 'left' }}>
        <h1 style={{ textAlign: 'center', color: '#2c3e50' }}>Latest Blog Posts</h1>
        <hr />
        {this.state.posts.map((post) => (
          <div key={post.id} style={{ marginBottom: '25px', borderBottom: '1px solid #eee', paddingBottom: '15px' }}>
            <h2 style={{ color: '#2980b9', textTransform: 'capitalize' }}>{post.title}</h2>
            <p style={{ color: '#34495e', lineHeight: '1.6' }}>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
