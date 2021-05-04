module.exports = (db) => ({
    createStudent: async (login, password) => {
        return db.query(``, [])
    },
    createAdmin: async (login, password) => {
        return db.query(``, [])
    },
    getUserId: async () => {
        return db.query(``, [])
    },
    getData : async (id) => {
        return db.query(``, [])
    }
})