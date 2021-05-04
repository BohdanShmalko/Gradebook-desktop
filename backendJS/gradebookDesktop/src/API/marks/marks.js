const {requestCreator} = require("shvidko");

const marks = requestCreator("post", "/marks/?semester;species", (req, res) => {
    res.send("hello from gradebook")
})

const practiceTable = requestCreator("post", "/practiceTable", (req, res) => {
    res.send("hello from gradebook")
})

const practice = requestCreator("post", "/practice", (req, res) => {
    res.send("hello from gradebook")
})

const atestations = requestCreator("post", "/atestations", (req, res) => {
    res.send("hello from gradebook")
})

const examsMarks = requestCreator("post", "/examsMarks", (req, res) => {
    res.send("hello from gradebook")
})

const degreeProject = requestCreator("post", "/degreeProject", (req, res) => {
    res.send("hello from gradebook")
})

const examinationCommission = requestCreator("post", "/examinationCommission", (req, res) => {
    res.send("hello from gradebook")
})

const teacher = requestCreator("post", "/teacher", (req, res) => {
    res.send("hello from gradebook")
})

const group = requestCreator("post", "/group", (req, res) => {
    res.send("hello from gradebook")
})

module.exports = [information, atestations, degreeProject, examinationCommission, examsMarks, marks, practice, practiceTable]