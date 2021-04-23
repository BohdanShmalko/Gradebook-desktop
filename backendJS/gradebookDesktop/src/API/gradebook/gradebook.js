const {requestCreator} = require("shvidko");

const information = requestCreator("get", "/information", (req, res) => {
    res.send("hello from gradebook")
})

const marks = requestCreator("get", "/marks/?semester;species", (req, res) => {
    res.send("hello from gradebook")
})

const practiceTable = requestCreator("get", "/practiceTable", (req, res) => {
    res.send("hello from gradebook")
})

const practice = requestCreator("get", "/practice", (req, res) => {
    res.send("hello from gradebook")
})

const atestations = requestCreator("get", "/atestations", (req, res) => {
    res.send("hello from gradebook")
})

const examsMarks = requestCreator("get", "/examsMarks", (req, res) => {
    res.send("hello from gradebook")
})

const degreeProject = requestCreator("get", "/degreeProject", (req, res) => {
    res.send("hello from gradebook")
})

const examinationCommission = requestCreator("get", "/examinationCommission", (req, res) => {
    res.send("hello from gradebook")
})

module.exports = [information, atestations, degreeProject, examinationCommission, examsMarks, marks, practice, practiceTable]