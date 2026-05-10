const modules = {
  dashboard: {
    resource: 'dashboard',
    label: 'Dashboard',

    inMenu: {
      label: 'Dashboard',
      icon: 'Dashboard',
      path: 'dashboard',
      menuPriority: 1,
    },
  },

  users: {
    resource: 'users',
    label: 'Users',

    inMenu: {
      label: 'Users',
      icon: 'People',
      path: 'users',
      menuPriority: 2,
    },
  },

  roles: {
    resource: 'roles',
    label: 'Roles',

    inMenu: {
      label: 'Roles',
      icon: 'Security',
      path: 'roles',
      menuPriority: 3,
    },
  },

  permissions: {
    resource: 'permissions',
    label: 'Permissions',

    inMenu: {
      label: 'Permissions',
      icon: 'VpnKey',
      path: 'permissions',
      menuPriority: 4,
    },
  },

  settings: {
    resource: 'settings',
    label: 'Settings',

    inMenu: {
      label: 'Settings',
      icon: 'Settings',
      path: 'settings',
      menuPriority: 5,
    },
  },

  logs: {
    resource: 'logs',
    label: 'Logs',

    inMenu: {
      label: 'Logs',
      icon: 'ReceiptLong',
      path: 'logs',
      menuPriority: 6,
    },
  },
};

export default modules;