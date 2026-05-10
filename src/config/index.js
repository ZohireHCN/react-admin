import admin from './admin';
import cc from './cc';

const configs = {
  admin,
  cc,
};

const appName = import.meta.env.VITE_APP_NAME || 'admin';

const config = configs[appName];

if (!config) {
  throw new Error(`Config introuvable: ${appName}`);
}

export default config;