<h1> Microblog </h1>

Micro blog is a blog service that allows saving, updating and reading blog posts (simple text).

Microblog is a  RESTful JSON API that handle the post resource (create, update, read, delete).

A user can “Like” a blog post.

The service also expose an API endpoint for receiving top trending(consider both created time and number of “likes”) posts.

The service accepts JSON requests and responds with a JSON response.

<h1> How to use this application? </h1>

Clone the code and run it.

Go to your web browser and get into `$ http://localhost:8080/blog`

<h4> To Get all Blogs </h4>

`$ http://localhost:8080/blog/trending`

<h4> To Get Blog by name </h4>

`$ http://localhost:8080/blog/trending/blogname/{Blogname}`

<h4> To Get Blog by Id </h4>

`$ http://localhost:8080/blog/trending/id/{Id_Number}`

<h4> To Post New Blog </h4>

`$ http://localhost:8080/blog`

and add json: 
{
"blogName": "Name of the Blog",
 "text": "Text of the Blog"
}

You can't create new Blog with Name that already exist.

<h4> To Delete Blog </h4>

`$ http://localhost:8080/blog/delete?Id={Blog id you wnat to delete}`

<h4> To Update Blog </h4>

`$ http://localhost:8080/blog/{Blog id you want to update}?name=New Blog name&text=New text you want to update`

<p> You can upadte only the name of the blog by:  </p>

`$ http://localhost:8080/blog/{Blog id you want to update}?name=New Blog name`

<p> You can upadte only the text of the blog by:  </p>

`$ http://localhost:8080/blog/{Blog id you want to update}?text=New text you want to update`

<h4> To Upvote a like to Blog</h4>

`$ http://localhost:8080/blog/Upvote?Id={Id blog you want to give a like}`










