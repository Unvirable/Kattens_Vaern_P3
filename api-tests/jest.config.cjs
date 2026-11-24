module.exports = {
    testEnvironment: 'node',

    transform: {},

    collectCoverageFrom: [
        'tests/**/*.js',
        '!tests/**/*.test.js',
        '!node_modules/**'
    ],

    testMatch: [
        '**/tests/**/*.test.js'
    ],

    maxWorkers: 1,

    verbose: true,

    testTimeout: 15000
};