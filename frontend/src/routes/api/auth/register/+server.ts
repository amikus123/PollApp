import type { RegisterDto } from '$lib/types/dto/register.dto';
import type { RequestHandler } from '@sveltejs/kit';
import { json } from '@sveltejs/kit';

import { API_URL } from '$env/static/private';
export const POST = (async ({ request }) => {
	const data = (await request.json()) as RegisterDto;
	const resposne = await fetch(`${API_URL}`);
	return json({ token: 'aaa' });
}) satisfies RequestHandler;
