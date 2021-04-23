module.exports = (db) => ({
    getInformation: async () => {
        return db.query(``, [])
    },
    getMarks: async () => {
        return db.query(``, [])
    },
    getPracticeTable: async () => {
        return db.query(``, [])
    },
    getPractice: async () => {
        return db.query(``, [])
    },
    getAtestations: async () => {
        return db.query(``, [])
    },
    getExamsMarks: async () => {
        return db.query(``, [])
    },
    getDegreeProject: async () => {
        return db.query(``, [])
    },
    getExaminationCommission: async () => {
        return db.query(``, [])
    }
})