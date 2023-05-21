import type { ErrorResposne } from './error.response';
import type { TokenResposne } from './token.resposne';

export type AuthResponse = TokenResposne | ErrorResposne;
