export * from "./apiTypes/R";
export * from "./apiTypes/CreatePostRequest";
export * from "./apiTypes/RegisterRequest";
export * from "./apiTypes/LoginRequest";

export type Primitive = undefined | null | boolean | string | number | symbol;
export type DeepRequired<T> = T extends Primitive ? T : keyof T extends never ? T : { [K in keyof T]-?: DeepRequired<T[K]> };
