const shvidko = require("shvidko");
const mainAppApi = require("./src/API/API");
const marksApi = require("./src/API/marks/API");
const gradebookApi = require("./src/API/gradebook/API");
const authApi = require("./src/API/auth/API");
const {Pool} = require('pg');

const db = new Pool({
    host: '127.0.0.1', port: 5432, database: 'gradebook_desktop', user: 'gradeuser', password: '1111'
});
db.connect();


const app = shvidko.createServer({});
app.listen(3001, "localhost", () => {
    console.log("server is start")
})
app.use(shvidko.middleware.sender()); // to use res.send (send data to the client)
app.use(shvidko.middleware.fileStorage("./files")); //to use file storage
app.use(shvidko.middleware.database(db)); //fill this variable with your database connection //to use db in requests
app.use(
    shvidko.middleware.cookieSession(
        //to use cookie sessions
        null, //session life in seconds
        "./sessions", //path where you want store sessions
        null //session client. It is has the default value (you can use libraries with a similar interface, such as shvidko-redis)
    )
);
app.use(
    shvidko.middleware.cors({
        "Access-Control-Allow-Methods": "GET, POST, DELETE, OPTIONS, PUT",
    })
);
app.use(
    shvidko.middleware.urlParser(
        // checking the existence of the page, the ability to transfer parameters
        app.routing, //app routing
        `<h1>Page not found in GET or DELETE request</h1>` //It is has the default value, can but you can indicate your interpretation when the page is not found
    )
);
app.use(
    shvidko.middleware.bodyParser(
        //checking the existence of the page, you can view the body of the POST and PUT requests
        app.routing, //app routing
        `<h1>Page not found in POST or PUT request</h1>` //It is has the default value, can but you can indicate your interpretation when the page is not found
    )
);

app.addEndPoints(...mainAppApi);

const marks = app.subroute("/marks");
marks.addEndPoints(...marksApi);
const gradebook = app.subroute("/gradebook");
gradebook.addEndPoints(...gradebookApi);
const auth = app.subroute("/auth");
auth.addEndPoints(...authApi);
