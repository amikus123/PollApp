import type { Actions } from './$types';

export const actions = {
	default: async ({ request, cookies }) => {
		const data = await request.formData();
		console.log({ data });
		const email = data.get('email');
		const password = data.get('password');
		const name = data.get('name');
		const rememberMe = data.get('rememberMe');
		console.log(name);
		// const user = await db.getUser(email);
		// cookies.set('sessionid', await db.createSession(user));

		return { success: true };
	}
} satisfies Actions;
