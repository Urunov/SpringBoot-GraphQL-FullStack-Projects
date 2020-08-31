"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const utils_1 = require("./utils");
function validateMiddleware(schema, middleware) {
    if (utils_1.isMiddlewareFunction(middleware)) {
        return middleware;
    }
    const types = schema.getTypeMap();
    Object.keys(middleware).forEach(type => {
        if (!Object.keys(types).includes(type)) {
            throw new MiddlewareError(`Type ${type} exists in middleware but is missing in Schema.`);
        }
        if (!utils_1.isMiddlewareFunction(middleware[type])) {
            const fields = types[type].getFields();
            Object.keys(middleware[type]).forEach(field => {
                if (!Object.keys(fields).includes(field)) {
                    throw new MiddlewareError(`Field ${type}.${field} exists in middleware but is missing in Schema.`);
                }
                if (!utils_1.isMiddlewareFunction(middleware[type][field])) {
                    throw new MiddlewareError(`Expected ${type}.${field} to be a function but found ` +
                        typeof middleware[type][field]);
                }
            });
        }
    });
    return middleware;
}
exports.validateMiddleware = validateMiddleware;
class MiddlewareError extends Error {
}
exports.MiddlewareError = MiddlewareError;
//# sourceMappingURL=validation.js.map