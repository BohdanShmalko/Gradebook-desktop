const {requestCreator, statusCode} = require("shvidko");
const SQL = require("../../database/auth/SQL")

const getUser = requestCreator("post", "/getUser", async (req, res) => {
    const db = SQL(req.db)
    const {login, password} = req.body
    const {id} = db.getUserId(login, password)
    if (!id) return res.send({error: "Не правильний логін чи пароль"}, statusCode.BadRequest)
    let token;
    try {
        token = await req.session.get();
    } catch (e) {
        token = await req.session.create({id});
    }
    res.send({token}, statusCode.OK)
})

const isRemember = requestCreator("post", "/remember", async (req, res) => {
    const {id} = await req.session.get();
    if (!id) return res.send({error: "You not authorize in past"}, statusCode.Unauthorized)
    const db = SQL(req.db);
    const {login, password} = db.getData(id);

    res.send({login, password}, statusCode.OK);
})

const createStudent = requestCreator("post", "/createUser", async (req, res) => {
    const db = SQL(req.db);
    const {login, password} = req.body;
    const {error} = await db.createStudent();
    if (error) return res.send({error}, statusCode.BadRequest);
    res.send("ok", statusCode.OK);
})

module.exports = [getUser, createStudent, isRemember];