export const buildMenu = modules => {
  return Object.keys(modules)
    .map(key => {
      const module = modules[key];

      if (!module.inMenu) return null;

      return {
        key,
        label: module.inMenu.label || module.label || key,
        icon: module.inMenu.icon,
        path: module.inMenu.path || module.resource || key,
        resource: module.resource,
        menuPriority: module.inMenu.menuPriority || 0,
      };
    })
    .filter(Boolean)
    .sort((a, b) => a.menuPriority - b.menuPriority);
};