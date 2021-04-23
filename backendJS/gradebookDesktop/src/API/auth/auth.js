const {requestCreator, statusCode} = require("shvidko");
const SQL = require("../../database/auth/SQL")

const getUser = requestCreator("post", "/getUser", async (req, res) => {
    const db = SQL(req.db)
    const {login, password} = req.body
    const {id} = db.getUserId(login, password)
    if (!id) return res.send("Не правильний логін чи пароль", statusCode.BadRequest)
    const token = await req.session.create({id});
    res.send(token, statusCode.OK)
})

const createUser = requestCreator("post", "/createUser", (req, res) => {
    const db = SQL(req.db)
    // const {login, password} = req.body //inf
    //const {id} = db.createUser();
    res.send("ok", statusCode.OK)
})

module.exports = [getUser, createUser]